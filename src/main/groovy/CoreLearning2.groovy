import io.vertx.groovy.core.Vertx

/**
 * Created by oscart on 05-12-2015.
 */
class CoreLearning2 {
    public static void main(String[] args) {
        def vertx = Vertx.vertx([workerPoolSize:40])


        vertx.setPeriodic(1000 * 3, { id ->
            // This handler will get called every second
            println("timer fired!")
            vertx.getOrCreateContext().runOnContext({ v ->
                println("This will be executed asynchronously in the same context")
            })

        })
    }
}
