package com.asn.leetcode.huawei.interview;


/**
    消防车救火任务：消防车在位置A，火灾发生在位置B。
    二维矩阵表示消防车到火灾现场的路况，矩阵中，0为可通过，1为障碍物。
    矩阵中消防车只能上下左右移动。消防车拥有1次机会破除障碍物，通过算法获取消防车到火灾的最短路径。
    例如：有如下火灾数据，消防车在fireMap[0][0] ，火灾点在fireMap[0][3]，则消防车到火灾点最短路径为3。消防车需要使用一次破除障碍的权限。
    A   0   1   B
    0   1   0   0
    0   0   0   0

 */
public class RescueFire {
    public static void main(String[] args) {
        int[][] arr = {{0,0,1,0},{0,1,0,0},{0,0,0,0}};
        //创建图对象
        DFSGraph graph = new DFSGraph(12);

        //初始化顶点和边
    }
    /**
     * 获取救火最佳路径
     * @param fireMap 火灾数据二维矩阵
     * @param startRow 消防车开始行坐标
     * @param startCol 消防车开始列坐标
     * @param endRow 火灾发生行坐标
     * @param endCol 火灾发生列坐标
     * @return 最短路径
     */
    public int rescue(int[][] fireMap, int startRow, int startCol, int endRow, int endCol) {
        //1、首先将数组封装成无向图

        //2、采用广度优先计算最短路径

        return 0;

    }

    public void help(){

    }
}
//定义图类
class DFSGraph {
    private int[][] adjMat;
    private Vertex[] vertexArr;
    private int num;
    private StackGraph sg;
    public DFSGraph(int s){
        num = 0;
        adjMat = new int[s][s];
        vertexArr = new Vertex[s];
        for(int i=0;i<s;i++){
            for(int j=0;j<s;j++){
                adjMat[i][j] = 0;
            }
        }
        sg = new StackGraph(s);
    }
    public void addVertex(char c){
        if(num<5){
            Vertex nVertex = new Vertex();
            nVertex.setName(c);
            vertexArr[num] = nVertex;
            System.out.println("添加顶点："+c+",所处数组下标为："+num);
            num++;
        }else{
            System.out.println("数组已满！");
        }
    }
    public void addEdge(int from,int to){
        adjMat[from][to] = 1;
        adjMat[to][from] = 1;
    }
    public void showGraph(){
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                int v = adjMat[i][j];
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }
    public void showVertex(int index){
        System.out.print(vertexArr[index].getName());
    }
    /**
     * 深度优先搜索算法
     *
     */
    public void dfs(){
        vertexArr[0].wasVisited = true;
        showVertex(0);
        sg.push(0);
        while(!sg.isEmpty()){
            int v = getAdjUnvisitedVertex(sg.peek());
            if(v==-1){
                sg.pop();//当当前节点找不到未被访问的临近节点时，将其从栈顶弹出
            }else{
                vertexArr[v].wasVisited = true;
                showVertex(v);
                sg.push(v);
            }
        }
        for(int j=0;j<num;j++){
            vertexArr[j].wasVisited = false;
        }
    }
    /**
     * 此方法根据传入的值查找对应的节点是否有未被访问过的临近节点，如果有，则将找到的第一个符合条件的临近节点的下标返回
     * 否则返回-1
     * @param v
     * @return
     */
    public int getAdjUnvisitedVertex(int v){
        for(int i=0;i<num;i++){
            if(adjMat[v][i]==1&&vertexArr[i].wasVisited==false){
                return i;//找到一个就返回
            }
        }
        return -1;
    }
}
//顶点类
class Vertex{
    private int row;
    private int col;
    public boolean wasVisited;
    public Vertex(int row,int col){
        this.wasVisited = false;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean wasVisited(){
        return this.wasVisited;
    }
}
//栈
class StackGraph{
    private int[] st;
    private int top;
    public StackGraph(int size){
        st = new int[size];
        top = -1;
    }
    public void push(int j){
        st[++top] = j;
    }
    public int pop(){
        return st[top--];
    }
    public int peek(){
        return st[top];
    }
    public boolean isEmpty(){
        return top == -1;
    }
}