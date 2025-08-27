package dslSamples

import com.epam.fej.routing.RoutingContext

import static dsl.CommonRulesDsl.rulesDSL


rulesDSL(routingContext as RoutingContext) {

    messageRules {
        messageRule("Test 2_1 Filter source by group, condition by fields, update message, send to several sessions by id") {
            source {
                id "session2"
            }
            condition {
                msgType "D"
            }
            action {
                ifCondition {
                    when {
                        exist 11
                    }
                    then {
                        sendTo "session1"
                    }
                    otherwise {
                        rejectMessage "TestReject"
                    }
                }
                custom {
                    ctx ->
                }
                context exit
            }
        }
        messageRule("Test 2_2 without otherwise block") {
            source {
                id "session2"
            }
            condition {
                msgType "AE"
            }
            action {
                ifCondition {
                    when {
                        exist 11
                    }
                    then {
                        sendTo "session1"
                    }
                }
                context exit
            }
        }
        messageRule("Test 2_3 without when block") {
            source {
                id "session1"
            }
            condition {
                msgType "AE"
            }
            action {
                ifCondition {
                    //without when
                    then {
                        sendTo "session2"
                    }
                    otherwise {
                        rejectMessage "TestReject"
                    }
                }
                context exit
            }
        }
        messageRule("Test 2_4 without then block") {
            source {
                id "session1"
            }
            condition {
                msgType "D"
            }
            action {
                ifCondition {
                    when {
                        exist 11
                    }
                    otherwise {
                        rejectMessage "TestReject"
                    }
                }
                context exit
            }
        }

    }
}