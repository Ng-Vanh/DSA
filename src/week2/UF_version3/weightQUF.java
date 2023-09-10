package week2.UF_version3;

public class weightQUF {
    private int id[];
    private int size[];
    weightQUF(int sz){
        id = new int[sz];
        size = new int[sz];
        for (int i = 0; i < sz; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }
    public int find(int index){
        while(index!=id[index]){
            index = id[index];
        }
        return index;// Tìm gốc
    }
    public void union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootQ!=rootP){
            if(size[rootP] > size[rootQ]){
                id[rootQ] = rootP;
                size[rootP] +=size[rootQ];
            }else{
                id[rootP] = rootQ;
                size[rootQ] +=size[rootP];
            }
        }
    }

}
