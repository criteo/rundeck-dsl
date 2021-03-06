import com.criteo.rundeck.dsl.model.LogLevel
import com.criteo.rundeck.dsl.model.RankOrder
import com.criteo.rundeck.dsl.model.Strategy

job('') {
    group('Runner Tests')
    name('most_directives')
    uuid('e5224053-200e-4b65-aabb-4cefaef01a10')

    description('''\
Invoke as much directives as possible
''')

    loglevel(LogLevel.DEBUG)
    loglimit('100') {
        halt('aborted')
    }

    executionEnabled(false)

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

    nodesSelectedByDefault()

    schedule {
        month('*')
        time {
            hour('3')
            minute('14')
            seconds('0')
        }
        weekday {
            day('1-5')
        }
        year('*')
    }

    scheduleEnabled()

    sequence {
        keepgoing()
        strategy(Strategy.STEP_FIRST)

        exec('echo hello world') {
            description('Say hello')
            errorhandler {
                keepgoingOnSuccess()
            }
        }

        script('''\
for i in hello world; do
  echo $i
done
'''.stripIndent()) {
            fileExtension('sh')
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
    maxPercentageOrchestrator {
        percent(18)
    }
}
