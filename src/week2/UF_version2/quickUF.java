package week2.UF_version2;

public class quickUF {
    private int id[];
    private int SoTPLT;
    private int soCanhConect;
    public quickUF(int sz){
        id = new int[sz];
        SoTPLT = sz;
        soCanhConect = 0;
        for (int i = 0; i < sz; i++) {
            id[i] = i;
        }
    }

    public int getSoTPLT() {
        return SoTPLT;
    }

    public int getSoCanhConect() {
        return soCanhConect;
    }

    public int find(int i){
        while (i != id[i]){
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q){

        int i = find(p);
        int j = find(q);
        if(i!=j){
            id[i] = j;
            SoTPLT--;
            soCanhConect++;
        }
    }

    public void getId(int sz){
        for (int i = 0; i < sz; i++) {
            System.out.println(i + " - " + id[i]);
        }
    }
}
