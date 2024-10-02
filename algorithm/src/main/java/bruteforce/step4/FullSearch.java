package bruteforce.step4;

import java.util.ArrayList;
import java.util.HashSet;

public class FullSearch {
    private int N = 4;
    private int M = 1;
    private int[] visited = new int[M+1];

    public static void main(String[] args) {

        FullSearch fullSearch = new FullSearch();

//        fullSearch.recur(0, new ArrayList<Integer>());
//        fullSearch.recur2(0, new ArrayList<>());
        fullSearch.recur3(0, new ArrayList<>(), 0);
    }

    public void bruteForce(){
        int N = 4;
        int M = 2;

        for(int i = 1 ; i <= N ; i++){
            for (int j = i; j <= N ; j++){
                System.out.printf(i + " " + j);
                System.out.println();
            }
        }
    }

    /**
     * 1 ~ N 까지 길이가 M개인 수열
     * 백트레킹의 가장 기본형
     * @param depth
     * @param dataList
     */
    public void recur(int depth, ArrayList<Integer> dataList){
        if(depth == M){
            System.out.println(dataList);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            dataList.add(i);
            recur(depth+1, dataList);
            dataList.remove(dataList.size() - 1);
        }
    }


    /**
     * 1 ~ N 까지 길이가 M개인 수열 자연수 중복 없이 M개
     * @param depth
     * @param dataList
     */
    public void recur2(int depth, ArrayList<Integer> dataList){
        if(depth == M){
            System.out.println(dataList);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if(visited[i] == 1) {
                continue;
            }
            dataList.add(i);
            visited[i] = 1;
            recur2(depth+1, dataList);
            dataList.remove(dataList.size() - 1);
            visited[i] = 0;
        }
    }

    /**
     * 1 ~ N 까지 길이가 M개인 수열 자연수 중복 없이 M개, 오름차순
     * @param depth
     * @param dataList
     */
    public void recur3(int depth, ArrayList<Integer> dataList, int j){
        if(depth == M){
            System.out.println(dataList);
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if(i <= j) continue;
            dataList.add(i);
            recur3(depth+1, dataList, i);
            dataList.remove(dataList.size() - 1);
        }
    }
}
