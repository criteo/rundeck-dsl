import com.criteo.rundeck.dsl.enums.LogLevel
import com.criteo.rundeck.dsl.enums.RankOrder
import com.criteo.rundeck.dsl.enums.Strategy

job('') {
    group('Runner Tests')
    name('most_directives')
    uuid(UUID.fromString('e5224053-200e-4b65-aabb-4cefaef01a10'))

    description('Invoke as much directives as possible')

    loglevel(LogLevel.DEBUG)
    loglimit('100') {
        halt('aborted')
    }

    multipleExecutions(true)
    retry(3)

    timeout('1h')

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

    nodefilters {
        dispatch {
            excludePrecedence()
            keepgoing()
            rankOrder(RankOrder.DESCENDING)
            threadcount(4)
        }
        filter('tags: ${option.include} !tags: ${option.exclude}')
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
            args('some')
            interpreter('tcsh') {
                argsQuoted()
            }
        }

        scriptFile('hello.sh') {
            args('world')
            interpreter('zsh')
        }

        scriptUrl('http://say/hello.sh') {
            interpreter('bash') {
                argsQuoted()
            }
        }

        jobref {
            args('hey ho')
            group('other')
            name('say-hello')
            nodeStep(true)

            nodefilters {
                dispatch {
                    excludePrecedence()
                    keepgoing(false)
                    rankOrder(RankOrder.ASCENDING)
                    threadcount(3)
                }
                filter('some')
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
