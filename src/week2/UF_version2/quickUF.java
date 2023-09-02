package week2.UF_version2;

public class quickUF {
    private int id[];
    public quickUF(int sz){
        id = new int[sz];
        for (int i = 0; i < sz; i++) {
            id[i] = i;
        }
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
        id[i] = j;
    }

    public void getId(int sz){
        for (int i = 0; i < sz; i++) {
            System.out.println(i + " - " + id[i]);
        }
    }
}
