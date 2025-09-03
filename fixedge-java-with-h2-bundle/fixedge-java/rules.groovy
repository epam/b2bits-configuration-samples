[
        rule("Route news messages to google pub/sub")
                .condition({
                    ctx -> true //ctx.getMessage().getTagValueAsString(35) == "<MSG_TYPE>" //filter by msg type
                })
                .action({
                    ctx ->
                        try {
//                            send(routingContext, ctx, "google_pub_sub_news") // send a message to the destination
                        } catch (all) {
                            logger.error(all.getMessage(), all)
                        }
                        ctx.exit()
                })
                .build(),
]
