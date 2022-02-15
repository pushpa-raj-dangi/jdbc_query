
public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnection.getConnection();

        DatabaseConnection connection = new DatabaseConnection();

        // connection.showData();

        // connection.updateData("Hari", 1);
        // connection.insertData(22, "krishna", "nepal");

        // for (int i = 0; i <= 500; i++) {
        // connection.insertData(getRadomNumber(), "pushpa" + getRadomNumber(),
        // "nepal" + getRadomNumber());

        // }
        // connection.deleteData(22);
        // connection.showData();

        boolean quit = true;

        while (quit) {

            System.out.println("what do you want");
        }

    }

    public static int getRadomNumber() {
        return (int) (Math.random() * (1000 - 500 + 1) + 500);
    }
}
