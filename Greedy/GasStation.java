package Greedy;
public class GasStation {
    public static int solve(int gas[],int cost[]){
        int totalGas = 0,totalCost = 0;
        int bal = 0,start = 0;

        for(int i=0;i<gas.length;i++){
            totalGas += gas[i];
            totalCost += cost[i];
            bal += gas[i] - cost[i];

            if(bal < 0){
                start = i + 1;
                bal = 0;
            }
        }
        if(totalGas >= totalCost) return start;
        else return -1;
    }
    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,4,5,1,2};
        System.out.println(solve(gas, cost));
    }
}
