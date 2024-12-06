package ro.stefantanasa.exercitii.threads;

/**
 *  2 threads ping-pong. One thread prints 'ping', another one prints' pong'. Stop after 5 seconds
 * Expected output is alternating ping-pong :
 * ping
 * pong
 * ping
 * pong
 * ping
 * pong
 */
public class SolutionThreads {
    public void solution() {
        Semaphore semaphore = new Semaphore();
        PingPongThread ping = new PingPongThread(Semaphore.State.PING, semaphore, 200);
        PingPongThread pong = new PingPongThread(Semaphore.State.PONG, semaphore, 100);
        ping.start();
        pong.start();

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        semaphore.finish();

        try {
            ping.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            pong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
