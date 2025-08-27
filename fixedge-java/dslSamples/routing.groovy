package rulesDsl

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL

rulesDSL(routingContext as RoutingContext) {
    routing {
        from "session2" to "session4"
        from "session1" to "session2", "session3"
        from "session3", "session4" to "session1"
        from "session5" to "session5"
    }
}