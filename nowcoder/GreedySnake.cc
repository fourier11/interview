#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <sstream>
#include <algorithm>
#include <stdlib.h>
#include <stdio.h>
#include <stack>
#include <ctime>
using namespace std;

//贪吃蛇的问题—相对比较难。现在有一个N*M(N，M=100)的方形矩形，在这个矩形的每一个方格上都放有一个随机值，一条可爱的小蛇从矩形的 左上角开始出发，每次移动都只能移动一格，向右或向下，而每到达一格贪吃的小蛇都会吧该位置上的值吃个一干二净，直到到达右下角时停止。而贪吃的小蛇不怕撑死，它只想吃到最多，并输出路径。
stack<int> st;
int value[100][100], best[100][100], n, m;
//value里面存储每个格子的值
//best 存储走到当前格子的最大值
//m,n为格子大小100*100


void initvalue()
{
    for (int i = 0; i < m; i++)
        for (int j = 1; j < n; j++)
        {
            srand(unsigned(time(NULL)));
            value[i][j] = (rand() % (1000 - 1 + 1)) + 1; //[a,b]
        }
    value[0][0] = 0;
}

int searchmaxvalue()
{
    best[0][0] = 0;
    for (int i = 1; i < m; i++)
    {
        best[i][0] = value[i][0] + best[i - 1][0];
    }
    for (int j = 1; j < n; j++)
    {
        best[0][j] += value[0][j] + best[0][j - 1];
    }
    for (int i = 1; i < m; i++)
        for (int j = 1; j < n; j++)
        {
            best[i][j] = value[i][j] + max(best[i - 1][j], best[i][j - 1]);
        }
    return best[m - 1][n - 1];
}

void Pu(int n, int m)
{
    st.push(n);
    st.push(m);
    if (n == 0 && m == 0)
        return;
    else if (n == 0 && m > 0)
        Pu(n, m - 1);
    else if (n > 0 && m == 0)
        Pu(n - 1, m);
    else
    {
        if (best[n - 1][m] > best[n][m - 1])
            Pu(n - 1, m);
        else
            Pu(n, m - 1);
    }
}
void print()
{
    Pu(99, 99);
    while (!st.empty())
    {
        cout << st.top() << "__";
        st.pop();
        cout << st.top();
        st.pop();
        cout << endl;
    }
}

int main()
{

    m = 100;
    n = 100;
    initvalue();
    int bestvalue = searchmaxvalue();

    cout << bestvalue;
    print();
    //先初始化价值矩阵之后，计算最大价值矩阵，然后输出路径
}