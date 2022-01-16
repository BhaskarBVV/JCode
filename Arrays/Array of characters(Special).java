char[][] a = new char[n][m];
String s;
for (int i = 0; i < n; i++) {
    s = sc.next();
    for (int j = 0; j < m; j++)
        a[i][j] = s.charAt(j);
}

// input array like: 
// 0010
// 1010
// 1101
// 1100
// Here every row is string and in java we can take character input as sc.next().charAt(0), 
// means it will only take only first chracter of all the strings into the matrix, and remaining characters will get discarded.

// Therefore, first take string as input and then take it's characters into the matrix.
