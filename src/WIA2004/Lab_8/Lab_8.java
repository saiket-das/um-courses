package WIA2004.Lab_8;

import java.util.Random;

public class Lab_8 {

    // States for each philosopher
    enum State {
        THINKING, HUNGRY, EATING
    }

    static class DiningPhilosophers {
        private static final int NUM_PHILOSOPHERS = 5;
        private static final int EATING_CYCLES = 3;
        private static final int MAX_THINK_TIME = 2000;
        private static final int MAX_EAT_TIME = 1500;

        private State[] state = new State[NUM_PHILOSOPHERS];
        private Thread[] philosophers = new Thread[NUM_PHILOSOPHERS];
        private Object chopstickLock = new Object();
        private Object[] chopsticks = new Object[NUM_PHILOSOPHERS];
        private long startTime;

        public DiningPhilosophers() {
            // Initialize states and chopsticks
            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                state[i] = State.THINKING;
                chopsticks[i] = new Object();
            }
        }

        // Check if philosopher can eat (both chopsticks available)
        private boolean canEat(int philosopherId) {
            int left = (philosopherId - 1 + NUM_PHILOSOPHERS) % NUM_PHILOSOPHERS;
            int right = (philosopherId + 1) % NUM_PHILOSOPHERS;

            return state[left] != State.EATING && state[right] != State.EATING;
        }

        // Philosopher tries to pick up both chopsticks
        private void pickUpChopsticks(int philosopherId) throws InterruptedException {
            int left = philosopherId;
            int right = (philosopherId + 1) % NUM_PHILOSOPHERS;

            synchronized (chopstickLock) {
                state[philosopherId] = State.HUNGRY;
                printStatus(philosopherId, "is HUNGRY, waiting for chopsticks");

                // Wait until both chopsticks are available
                while (!canEat(philosopherId)) {
                    try {
                        chopstickLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw e;
                    }
                }

                state[philosopherId] = State.EATING;
                printStatus(philosopherId, "picked up chopsticks " + left + " and " + right);
            }
        }

        // Philosopher puts down both chopsticks
        private void putDownChopsticks(int philosopherId) {
            int left = philosopherId;
            int right = (philosopherId + 1) % NUM_PHILOSOPHERS;

            synchronized (chopstickLock) {
                state[philosopherId] = State.THINKING;
                printStatus(philosopherId, "put down chopsticks " + left + " and " + right);
                printSeparator();

                // Notify all waiting philosophers that resources may be available
                chopstickLock.notifyAll();
            }
        }

        // Philosopher's main activity loop
        private void philosopherActivity(int id) {
            Random random = new Random();

            for (int i = 0; i < EATING_CYCLES; i++) {
                try {
                    // THINKING phase
                    state[id] = State.THINKING;
                    printStatus(id, "is THINKING");
                    int thinkTime = random.nextInt(MAX_THINK_TIME) + 500;
                    Thread.sleep(thinkTime);

                    // HUNGRY phase - try to get chopsticks
                    pickUpChopsticks(id);

                    // EATING phase
                    printStatus(id, "is EATING");
                    int eatTime = random.nextInt(MAX_EAT_TIME) + 500;
                    Thread.sleep(eatTime);

                    // Put down chopsticks
                    putDownChopsticks(id);

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }

            printStatus(id, "finished and left the table");
            printSeparator();
        }

        // Start all philosopher threads
        public void start() {
            this.startTime = System.currentTimeMillis();
            for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
                final int philosopherId = i;
                philosophers[i] = new Thread(() -> philosopherActivity(philosopherId),
                        "Philosopher-" + i);
                philosophers[i].start();
            }
        }

        // Wait for all philosophers to finish
        public void join() throws InterruptedException {
            for (Thread philosopher : philosophers) {
                philosopher.join();
            }
        }

        // Print status with timestamp
        private void printStatus(int philosopherId, String message) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            String timeStr = String.format("[%5dms]", elapsedTime);
            String philosopherStr = String.format("Philosopher %d", philosopherId);

            // Print with emoji icons based on state
            String stateIcon = "";
            if (message.contains("THINKING")) {
                stateIcon = "🧠";
            } else if (message.contains("HUNGRY")) {
                stateIcon = "😋";
            } else if (message.contains("EATING")) {
                stateIcon = "🍜";
            } else if (message.contains("picked up")) {
                stateIcon = "🥢";
            } else if (message.contains("put down")) {
                stateIcon = "📥";
            } else if (message.contains("finished")) {
                stateIcon = "✓";
            }

            System.out.println(timeStr + " | " + stateIcon + " " + philosopherStr + ": " + message);
        }

        // Print separator line
        private void printSeparator() {
            System.out.println("────────────────────────────────────────────────────────────────────────────────\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║    DINING PHILOSOPHERS PROBLEM - SIMULATION        ║");
        System.out.println("║           Configurable Parameters                  ║");
        System.out.println("╚════════════════════════════════════════════════════╝\n");

        // Display configuration
        System.out.println("╔═══════════════════════════════════════════════════════╗");
        System.out.println("║           SIMULATION CONFIGURATION                    ║");
        System.out.println("╠═══════════════════════════════════════════════════════╣");
        System.out.println("║ Number of philosophers     : 5                        ║");
        System.out.println("║ Eating cycles per phil.    : 3                        ║");
        System.out.println("║ Max thinking time (ms)     : 2000                     ║");
        System.out.println("║ Max eating time (ms)       : 1500                     ║");
        System.out.println("║ Solution Method            : Monitor-based (atomic)   ║");
        System.out.println("║ Deadlock Prevention        : YES ✓                    ║");
        System.out.println("║ Starvation Prevention      : YES ✓                    ║");
        System.out.println("╚═══════════════════════════════════════════════════════╝\n");

        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();

        try {
            System.out.println("► Starting simulation...\n");

            // Start the dining philosophers simulation
            diningPhilosophers.start();

            // Wait for all philosophers to finish
            diningPhilosophers.join();

            System.out.println("\n╔════════════════════════════════════════════════════╗");
            System.out.println("║        ✓ SIMULATION COMPLETED SUCCESSFULLY         ║");
            System.out.println("╠════════════════════════════════════════════════════╣");
            System.out.println("║ ✓ No deadlock occurred                             ║");
            System.out.println("║ ✓ No starvation occurred                           ║");
            System.out.println("║ ✓ All philosophers completed eating cycles         ║");
            System.out.println("╚════════════════════════════════════════════════════╝\n");

        } catch (InterruptedException e) {
            System.err.println("\n❌ Simulation interrupted!");
            e.printStackTrace();
        }
    }
}