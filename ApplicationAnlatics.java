
 

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

 

// Enum to represent actions
enum ActionEnum {
    // Define action types here
    feature1Button, feature2Button, feature3Button,
    // Add more actions as needed
}

 

class Analytics {
    private final int k;
    private Queue<ActionEnum> actionsQueue;
    private Map<ActionEnum, Integer> actionCounts;
    private lAnalyticsStore analyticsStore;

 

    public Analytics(lAnalyticsStore analyticsStore, int k) {
        this.k = k;
        this.analyticsStore = analyticsStore;
        this.actionsQueue = new LinkedList<>();
        this.actionCounts = new HashMap<>();
    }

 

    public void registerAction(ActionEnum action) {
        actionsQueue.add(action);
        actionCounts.put(action, actionCounts.getOrDefault(action, 0) + 1);

 

        if (actionsQueue.size() == k) {
            // Send the actions in order to the analyticsStore
            analyticsStore.storeActions(new LinkedList<>(actionsQueue));
            actionsQueue.clear();
        }
    }

 

    public int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        return actionsQueue.size();
    }

 

    public int getTotalNumberOfLoggedActions() {
        int totalCount = 0;
        for (int count : actionCounts.values()) {
            totalCount += count;
        }
        return totalCount;
    }

 

    public List<ActionEnum> getMostFrequentlyUsedActions() {
        List<ActionEnum> mostFrequentActions = new ArrayList<>();
        int maxFrequency = 0;

 

        for (Map.Entry<ActionEnum, Integer> entry : actionCounts.entrySet()) {
            int frequency = entry.getValue();
            if (frequency > maxFrequency) {
                mostFrequentActions.clear();
                maxFrequency = frequency;
            }

 

            if (frequency == maxFrequency) {
                mostFrequentActions.add(entry.getKey());
            }
        }

 

        mostFrequentActions.sort(Comparator.comparing(Enum::name));
        return mostFrequentActions;
    }
}

 

// Interface to represent the AnalyticsStore
interface lAnalyticsStore {
    void storeActions(Queue<ActionEnum> actions);
}

 

class ConsoleAnalyticsStore implements lAnalyticsStore {
    @Override
    public void storeActions(Queue<ActionEnum> actions) {
        System.out.print(" ");
        while (!actions.isEmpty()) {
            System.out.print(actions.poll().name() + " ");
        }
        System.out.println();
    }
}

 

public class APPLICATION_ANALYTICS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumberOfRequests = scanner.nextInt();
        int k = scanner.nextInt();

 

        // Create the AnalyticsStore instance
        lAnalyticsStore analyticsStore = new ConsoleAnalyticsStore();

 

        // Create the Analytics instance
        Analytics analytics = new Analytics(analyticsStore, k);

 

        for (int i = 0; i < totalNumberOfRequests; i++) {
            String request = scanner.next();
            switch (request) {
            case "registerAction":
                ActionEnum action = ActionEnum.valueOf(scanner.next());
                analytics.registerAction(action);
                break;
            case "getTotalNumberOfLoggedActions":
                System.out.println(analytics.getTotalNumberOfLoggedActions());
                break;
            case "getMostFrequentlyUsedActions":
                List<ActionEnum> mostFrequentActions = analytics.getMostFrequentlyUsedActions();
                for (ActionEnum act : mostFrequentActions) {
                    System.out.print(act.name() + " ");
                }
                System.out.println();
                break;
            case "getNumberOfActionRegisteredButNotSentToAnalyticsStore":
                System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
                break;
            default:
                System.out.println("Invalid request");
                break;
            }
        }
    }
}