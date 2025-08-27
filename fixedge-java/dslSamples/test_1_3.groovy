package dslSamples

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL

rulesDSL(routingContext as RoutingContext) {

    messageRules {

        messageRule("Rule with complex conditions") {
            source {
                or {
                    id "session*"
                    //targetCompId ".*ID.*"

                    session {
                        targetCompId ".*ID.*"
                        senderCompId ".*ID*"
                    }

                    session {
                        id "session1"
                    }
                }
            }
            condition {
                or {
                    field(11) {
                        value "OR2"
                    }
                    msgType "D"
                }
            }
            action {
                send by groups "A", "B"
                context exit
            }
        }
    }
}