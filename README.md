# USACO_SOLUTIONS
USACO etc

// combo.java 

I'm very happy with how this one turned out... 

By filtering the data and putting them into vectors, I was able to reduce the worst case scenario to exactly 5^3 * 2 ----> 250 time units. 

This is a lot better than simply jamming out the permutations which has a performance of O(n^3) or a worst case of 1,000,000 time units ... NO THANKS on that one! LOL. 

I know the HashSet adds a little more space but honestly it's reliable and gets the job done so that's why I like them. 

The string concatenation with the hyphens helps the HashSet determine unique combinations or not. 

-Tyler
7/29/2019
