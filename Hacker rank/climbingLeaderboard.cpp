#include <bits/stdc++.h>
#include <iostream>
#include <vector>

using namespace std;

vector<string> split_string(string);

// Finished fct
vector<int> climbingLeaderboard(vector<int> scores, vector<int> alice) {
    const unsigned int n = scores.size();
    const unsigned int m = alice.size();
    unsigned int rank = 1;
    vector<int> aliceRank =  vector<int>();
    int j = m-1;
    int i=0;

    //Insert loop rank 1 to all alice >= scores[0]
    while(alice[j] >= scores[0]) {
        aliceRank.insert(aliceRank.begin(),1);
        //cout << "Alice : " << alice[j] << " : " << 1 << endl;
        j--;
    }
    i++;
    while(i<n && j>=0) {
    //for(unsigned int i=1;i<n;++i) {
        if(scores[i] < scores[i-1]) {
            rank++;
        }
        while(scores[i] <= alice[j]) {
            //it=aliceRank.begin();
            aliceRank.insert(aliceRank.begin(),rank);
            //cout << "Alice : " << alice[j] << " : " << rank << endl;
            j--;
        }
        //cout << scores[i] << " : " << rank << endl;
        ++i;
    }

    while(j >=0) {
        aliceRank.insert(aliceRank.begin(),rank+1);
        //cout << "Alice : " << alice[j] << " : " << rank+1 << endl;
        j--;
    }

    return aliceRank;
}

int main(int argc, char const *argv[])
{
    vector<int> score;
    score.push_back(100);
    score.push_back(90);
    score.push_back(90);
    score.push_back(80);
    score.push_back(75);
    score.push_back(60);
    //score.push_back(10);

    vector<int> alice;
    alice.push_back(50);
    alice.push_back(65);
    alice.push_back(77);
    alice.push_back(90);
    alice.push_back(102);

    vector<int> res = climbingLeaderboard(score,alice);
    for(int i=0;i<res.size();++i) {
        cout << res[i] << endl;
    }
    return 0;
}

vector<string> split_string(string input_string) {
    string::iterator new_end = unique(input_string.begin(), input_string.end(), [] (const char &x, const char &y) {
        return x == y and x == ' ';
    });

    input_string.erase(new_end, input_string.end());

    while (input_string[input_string.length() - 1] == ' ') {
        input_string.pop_back();
    }

    vector<string> splits;
    char delimiter = ' ';

    size_t i = 0;
    size_t pos = input_string.find(delimiter);

    while (pos != string::npos) {
        splits.push_back(input_string.substr(i, pos - i));

        i = pos + 1;
        pos = input_string.find(delimiter, i);
    }

    splits.push_back(input_string.substr(i, min(pos, input_string.length()) - i + 1));

    return splits;
}
