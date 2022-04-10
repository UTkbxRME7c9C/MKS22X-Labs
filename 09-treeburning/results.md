# I BURN TREES I LOVE TO BURN DIGITAL TREES

### 1.  Why did you choose the board size for your finalized table?
I chose 500x500 because it is large enough to produce more consistent results (less range) than a smaller table, and is small enough to not take too long to run for multiple tests.
### 2.  Why did you choose the number of repetitions size for your finalized table?
I chose 10 repetitions per density (19 densities * 10 = 190 repetitions total) because it produces more
### 3.  What did your testing show about changing the board size?
As the size increases, the burn time is more consistent per test, and it increases the most at the smaller sizes (100-500), but as it gets bigger it increases time less.
### 4.  Knowing that there were differences based on board size, what was the relationship between the board size and the maximum burn time? How did you test this?
The burn time increases logarithmically because it increases the most when the board size is smaller, but larger sizes increase burn time the least. I tested this by making a table to sizes 100 to 1500 with intervals of 100, and doing 5 tests for each.
### 5.  What density of trees yields the maximum burn time?
The density 60% produces the maximum burn time.


## Table for max burn time on different size (60% density, length==width)

Size (length) | Tick 1 | Tick 2 | Tick 3 | Tick 4 | Tick 5 | Avg Tick
--- | --- | --- | --- | --- | --- | ---
Size 100 | 224 | 200 | 131 | 245 | 206 | 201.2
Size 200 | 466 | 692 | 426 | 467 | 374 | 485.0
Size 300 | 734 | 874 | 331 | 455 | 724 | 623.6
Size 400 | 841 | 1356 | 1185 | 853 | 1009 | 1048.8
Size 500 | 259 | 972 | 1884 | 1446 | 1189 | 1150.0
Size 600 | 1284 | 1527 | 1319 | 1237 | 1507 | 1374.8
Size 700 | 1992 | 1648 | 1662 | 2169 | 1548 | 1803.8
Size 800 | 2429 | 1761 | 2031 | 2073 | 2189 | 2096.6
Size 900 | 2343 | 2397 | 3042 | 2024 | 2010 | 2363.2
Size 1000 | 3009 | 2779 | 2414 | 2333 | 2246 | 2556.2
Size 1100 | 2373 | 3007 | 2313 | 2367 | 2230 | 2458.0
Size 1200 | 2563 | 3031 | 3115 | 2758 | 2754 | 2844.2
Size 1300 | 5108 | 3012 | 4019 | 3279 | 3042 | 3692.0
Size 1400 | 3423 | 3392 | 3456 | 3289 | 3081 | 3328.2
Size 1500 | 3603 | 4291 | 3672 | 4084 | 3835 | 3897.0

## Table for densities 5% to 95% (5% intervals)

Density | Avg. Ticks
--- | ---
Density 5% | 2.1
Density 10% | 2.9
Density 15% | 4.8
Density 20% | 4.9
Density 25% | 7.9
Density 30% | 7.7
Density 35% | 13.4
Density 40% | 18.2
Density 45% | 31.8
Density 50% | 55.0
Density 55% | 123.8
Density 60% | 1109.4
Density 65% | 768.1
Density 70% | 669.6
Density 75% | 618.9
Density 80% | 585.7
Density 85% | 559.1
Density 90% | 537.9
Density 95% | 520.4

## Table for densities 55% to 65% (near maximum)

Density | Avg. Ticks
--- | ---
Density 55% | 120.4
Density 56% | 192.8
Density 57% | 269.7
Density 58% | 465.4
Density 59% | 921.7
Density 60% | 1319.1
Density 61% | 1075.0
Density 62% | 956.3
Density 63% | 850.4
Density 64% | 810.9
Density 65% | 761.1
