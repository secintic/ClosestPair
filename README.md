# ClosestPairFinder:

Algorithm running time: O(n(logn)^m-1) ; m is the number of dimension. It is assumed as constant.

Limitations: 
1. Filename should be written in to main class.
2. Only reads from '.tsv files'.

Algorithm --> Divide and Conquer:
1. Divides data into two according to one selected dimension.
2. Checks division point closer points to find any missing closest point on the data.
3. Go to step 1 if there are any dimension which is not analysed yet.

Technologies:
1. Gradle
2. Lombok
3. Java 8
4. The code is developed in Intellij IDE.