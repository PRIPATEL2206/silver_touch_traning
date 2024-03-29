# file 96.py
def maximalNetworkRank(n, roads):
    # Create an adjacency matrix to represent the graph
    graph = [[0] * n for _ in range(n)]

    # Count the number of roads connecting each city
    city_connections = [0] * n
    for road in roads:
        city_connections[road[0]] += 1
        city_connections[road[1]] += 1
        graph[road[0]][road[1]] = 1
        graph[road[1]][road[0]] = 1

    # Calculate the maximal network rank
    max_rank = 0
    for i in range(n):
        for j in range(i + 1, n):
            rank = city_connections[i] + city_connections[j] - graph[i][j]
            max_rank = max(max_rank, rank)

    return max_rank

# Example usage:
n = 5
roads = [[0, 1], [0, 3], [1, 2], [1, 4], [2, 4], [3, 4]]
result = maximalNetworkRank(n, roads)
print("Maximal Network Rank:", result)
