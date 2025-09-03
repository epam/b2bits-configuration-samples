package dslSamples

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL

rulesDSL(routingContext as RoutingContext) {

    messageRules {
        messageRule("From session2 all msg with type D redirect to session1") {
            source {
                id "session2"
            }
            condition {
                msgType "D"
            }
            action {
                sendTo "session1"
                context exit
            }
        }
    }
}