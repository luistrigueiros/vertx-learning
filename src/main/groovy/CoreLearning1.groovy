import io.vertx.groovy.core.Vertx

/**
 * Created by oscart on 05-12-2015.
 */
class CoreLearning1 {
    public static void main(String[] args) {
        def vertx = Vertx.vertx([workerPoolSize:40])

        vertx.setPeriodic(1000, { id ->
            // This handler will get called every second
            println("timer fired!")
        })
    }
}
