package context;

public class TestContext {

    private static String groupName;

    public static void setGroupName(String groupName) {
        TestContext.groupName = groupName;
    }

    public static String getGroupName() {
        return groupName;
    }
}