package isp.lab3.exercise5;

public class VendingMachine {
    private String[] products={"Chips","Burger","Cola","Snicker","Covrig","Water","Biscuits","BakeRolls",};
    private int[] id_products={11,12,13,14,21,22,23,24};
    private float credit=0;


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
    public void textMenu(){
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
        VendingMachine machine1=new VendingMachine();
        System.out.println(machine1.displayProducts());
        System.out.println(machine1.selectProduct(11));
        machine1.insertCoin(12);
        System.out.println(machine1.getCredit());
        machine1.textMenu();
    }

}
