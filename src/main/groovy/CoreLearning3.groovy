import io.vertx.groovy.core.Vertx

class CoreLearning3 {
    public static void main(String[] args) {
        def vertx = Vertx.vertx([workerPoolSize:40])
        def eb = vertx.eventBus()

        eb.consumer("news.uk.sport", { message ->
            println("I have received a message: ${message.body()}")
        })

        vertx.setPeriodic(1000 * 3, { id ->
            // This handler will get called every second
            eb.publish("news.uk.sport", "timer fired!")
        })
    }
}
