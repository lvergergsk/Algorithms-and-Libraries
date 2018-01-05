#include <iostream>
#include <vector>
#include <iomanip>
 
using grid = std::vector<std::vector<int>>;
 
void traverseDL(int &i, int &j) {
    i++;
    j--;
}
 
void traverseUR(int &i, int &j) {
    i--;
    j++;
}
 
void traverseEdge(int &i, int &j, const short &N) {
    if (i == 0 && j + 1 < N) j++;
    else if (j == 0 && i + 1 < N) i++;
    else if (i == N - 1) j++;
    else if (j == N - 1) i++;
}
 
int main() {
    short N; //0<N<10;
    int caseNumber = 1;
    grid* order;
    while (true) {//loop the input case
        std::cin >> N;
        if (N == 0) return 0;
        order = new grid(N, std::vector<int>(N));
        //i+j<k, i<N, j<N, i:row, j:column
        bool direction = false; //true: down-left or down or right , false: up-right or right or down
        int i = 0, j = 0, count = 1;
        while (true) {
            while (true) {
                (*order)[i][j] = count++;
                if ((direction && (j == 0 || i == N-1)) || (!direction && (j == N-1 || i == 0))) break;
                direction ? traverseDL(i, j) : traverseUR(i, j);
            }
            if (i == N - 1 && j == N - 1) break;
            traverseEdge(i, j, N);
            direction = !direction;
        }
        std::cout << "Case " << caseNumber++ << ":\n";
        for (grid::iterator it1 = order->begin(); it1 != order->end(); ++it1) {
            for (std::vector<int>::iterator it2 = it1->begin(); it2 != it1->end(); ++it2) {
                std::cout << std::setw(3)<<std::right<<*it2;
            }
            std::cout << "\n";
        }
        delete order;
    }
}