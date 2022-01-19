public class Phone {
    private String number;
    private String model;
    private int weight;

    public Phone(String number, String model, int weight) {
        this(number, model);
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public String getNumber() {
        return number;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }
    public static void receiveCall(String name){
        System.out.println("Звонит " + name);
    }
    public static void receiveCall(String name, String number){
        System.out.println("Звонит " + name + ". Номер звонящего: " + number);
    }
    public static void sendMessage(String ...ags){
        for (String st:ags) {
            System.out.println(st);
        }
    }
}
