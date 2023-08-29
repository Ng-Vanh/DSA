package week2.UF_version1;

public class UF {

    private int id[];
    void getId(int sz){
        for (int i = 0; i < sz; i++) {
            System.out.println(i+" - " + id[i]);
        }
    }
    public UF(int sz) {
        id = new int[sz];
        for(int i=0; i<sz; i++){
            id[i] = i;
        }
    }
    public void union(int p, int q){
        //add conection p and q
        int pId = id[p];
        int qId = id[q];
        for(int i=0; i<id.length; i++){
            if(id[i] == pId){
                id[i] = qId;
            }
        }
    }
    public int find(int p){
        return id[p];
    }
    boolean connected(int p, int q){
        return id[p] == id[q];
    }
}
