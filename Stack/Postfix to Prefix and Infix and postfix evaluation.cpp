#include <bits/stdc++.h>
using namespace std;
bool is_operator(char ch)
{
    if (ch == '+' || ch == '-' || ch == '*' || ch == '/')
        return true;
    return false;
}

int precedence(char ch)
{
    if (ch == '+' || ch == '-')
        return 1;
    return 2;
}
int get_val(int a, int b, char ch)
{
    if (ch == '+')
        return a + b;
    else if (ch == '*')
        return a * b;
    else if (ch == '/')
        return a / b;
    return a - b;
}
int main()
{
    string postfix;
    cin >> postfix;
    stack<string> infix, prefix;
    stack<int> value;
    char ch;
    for (int i = 0; i < postfix.size(); i++)
    {
        ch = postfix[i];
        if (is_operator(ch))
        {
            string prefixV2 = prefix.top();
            prefix.pop();
            string prefixV1 = prefix.top();
            prefix.pop();
            prefix.push(ch + prefixV1 + prefixV2);

            string infixV2 = infix.top();
            infix.pop();
            string infixV1 = infix.top();
            infix.pop();
            infix.push("(" + infixV1 + ch + infixV2 + ")");

            int valueV2 = value.top();
            value.pop();
            int valueV1 = value.top();
            value.pop();
            value.push(get_val(valueV1, valueV2, ch));
        }
        else if (ch >= '0' && ch <= '9')
        {
            string temp = "";
            temp += ch;
            infix.push(temp);
            prefix.push(temp);
            value.push(ch - '0');
        }
    }

    cout << infix.top() << endl;
    cout << prefix.top() << endl;
    cout << value.top() << endl;
}
