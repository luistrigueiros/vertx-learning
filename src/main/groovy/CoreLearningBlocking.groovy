import io.vertx.groovy.core.Vertx

class CoreLearningBlocking {

    String blockingMethod(String msg) {
        Thread.sleep(1000 * 5)
        println("Hello  $msg")
        return "Done blocking"
    }

    public static void main(String[] args) {
        def vertx = Vertx.vertx()

        vertx.executeBlocking({future ->
            CoreLearningBlocking clb = new CoreLearningBlocking()
            String result = clb.blockingMethod("Oscar")
            future.complete(result)
        }, { res ->
            if(res.succeeded()) {
                println("Done ok " + res.result())
            }else {
                res.cause().printStackTrace()
            }
        })
    }
}