package dslSamples

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL

rulesDSL(routingContext as RoutingContext) {

    messageRules {
        messageRule("Filter source by group, condition by fields, update message, send to several sessions by id") {
            source {
                groups {
                    contains any from "A", "B", "D"
                    size 3
                }
                available_destinations {
                    quantity 4 by_groups "A", "B", "C"
                }
            }
            condition {

                exist 11, 38 // all
                field(38) {
                    or {
                        value ".*" //have work with any value type!
                        value greater than 0.1
                        value less than 5
                        begin_with ""
                    }
                }
            }
            action {
                fields {
                    set 555 value "CustomField" //add new
                    modify 11 value "OR3" //update exist
                    remove 55
                }
                sendTo "session3", "session4"

                rejectMessage "Test message reject"
                context exit
            }
        }
    }

}