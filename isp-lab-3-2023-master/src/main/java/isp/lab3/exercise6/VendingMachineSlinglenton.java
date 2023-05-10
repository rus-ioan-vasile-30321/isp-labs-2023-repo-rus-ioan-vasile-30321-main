package isp.lab3.exercise6;




public final class VendingMachineSlinglenton {
    private static volatile VendingMachineSlinglenton instance;
    private String[] products={"Chips","Burger","Cola","Snicker","Covrig","Water","Biscuits","BakeRolls",};
    private int[] id_products={11,12,13,14,21,22,23,24};
    private float credit=0;
    private VendingMachineSlinglenton(){}
    public static VendingMachineSlinglenton getInstance(){
        if(instance==null){
            synchronized (VendingMachineSlinglenton.class){
                if(instance==null){
                    instance=new VendingMachineSlinglenton();
                }
            }
        }
        return instance;
    }
    public String displayProducts(){
        String output = "";
        for(int i=0;i<=7;i++)
            output=output.concat(" Product:"+this.products[i]+"CODE:"+this.id_products[i]);
        return output;
    }
    public void insertCoin(int value){
        this.credit+=value;

    }
    public float getCredit() {
        return credit;
    }
    public String selectProduct(int id){
        for(int i=0;i<=7;i++)
            if(this.id_products[i]==id)return "Name product:"+products[i];
        return "The id is incorect!";
    }
    public void displayCredit(){
        System.out.println(this.credit);
    }
    public void userMenu(){
        System.out.println("Vending Machine:");
        System.out.print("Product available:");
        for (int i=0;i<=7;i++) System.out.print(this.products[i]+" ");
        System.out.println();
        System.out.print("\t   ID product:");
        for (int i=0;i<=7;i++) System.out.print(this.id_products[i]+"     ");
        System.out.println();
        System.out.println("Credit available:"+this.credit);
        System.out.println("How to use this vending Machine?");
        System.out.println("Choice the instruction from the list below:");
        System.out.println("1.InsertCoins");
        System.out.println("2.SelectProduct");
        System.out.println("3.CancelOperation");
    }


    public static void main(String[] args) {


    }
}
class Main{
    public static void main(String[] args) {
        VendingMachineSlinglenton machine1=VendingMachineSlinglenton.getInstance();
        VendingMachineSlinglenton machine2=VendingMachineSlinglenton.getInstance();
        machine1.insertCoin(20);
        machine2.insertCoin(40);
        System.out.println(machine2.getCredit());
        System.out.println(machine2+" "+machine1);
    }
}