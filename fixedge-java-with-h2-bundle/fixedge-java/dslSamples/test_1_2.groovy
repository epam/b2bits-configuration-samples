package dslSamples

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL

rulesDSL(routingContext as RoutingContext) {

    messageRules {

        messageRule("Echo rule with custom implementation") {
            source {
                custom { source -> source.id == "session2" }
            }
            condition {
                custom { ctx -> ctx.getMessage().getTagValueAsString(35) == "AE" }
            }
            action {
                custom {
                    ctx ->
                        routingContext.getDestinationById("session2").send(ctx.messageEvent)
                        logger.info("run custom action")
                        ctx.exit()
                }
            }
        }
    }
}