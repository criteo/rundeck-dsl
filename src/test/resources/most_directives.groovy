import com.criteo.rundeck.dsl.enums.LogLevel
import com.criteo.rundeck.dsl.enums.RankOrder
import com.criteo.rundeck.dsl.enums.Strategy

job('') {
    group('Runner Tests')
    name('most_directives')
    uuid(UUID.fromString('e5224053-200e-4b65-aabb-4cefaef01a10'))

    description('Invoke as much directives as possible')

    loglevel(LogLevel.DEBUG)
    logging {
        limit('100') {
            halt('aborted')
        }
    }

    multipleExecutions(true)
    retry(3)

    timeout('1h')

    context {
        options {
            preserveOrder()

            option('include')
            option('exclude')
            option('dc') {
                required()
                enforcedValues()
                values('tokyo', 'amsterdam', 'new-york')
                multivalued()
                delimiter(',')
                value('tokyo')
            }
        }
    }

    nodefilters {
        filter('tags: ${option.include} !tags: ${option.exclude}')
        excludePrecedence()
    }

    dispatch {
        keepgoing()
        rankOrder(RankOrder.DESCENDING)
        threadcount(4)
    }

    schedule {
        crontab('0 47 20 ? * * *')
    }

    sequence {
        keepgoing()
        strategy(Strategy.STEP_FIRST)

        exec('echo hello world') {
            description('Say hello')
        }

        script('''\
for i in hello world; do
  echo $i
done
'''.stripIndent()) {
            description('When several lines are required')
        }

        scriptFile('hello.sh') {
            args('world')
            interpreter('zsh')
        }

        scriptUrl('http://say/hello.sh')

        jobref {
            group('other')
            name('say-hello')
            nodeStep(true)

            nodefilters {
                filter('some')
                excludePrecedence()
            }

            dispatch {
                keepgoing(false)
                rankOrder(RankOrder.ASCENDING)
                threadcount(3)
            }
        }

        localexec('echo bonjour monde') {
            description('Saying it in French')
        }
    }

    notification {
        onfailure {
            email {
                attachLog()
                recipients('all@foo.bar')
                subject('World is Failing!')
            }
        }
        onsuccess {
            plugin {
                configuration {
                    entry('color', 'blue')
                }
                type('telltale')
            }
        }
        onstart {
            webhook(new URL('http://foo.bar'))
        }
    }
}
