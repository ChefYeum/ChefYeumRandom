from operator import itemgetter

def distance(list):
    return abs(list[0]-list[2])+abs(list[1]-list[3])

if __name__ == "__main__":

    with open("a_example.in","r") as file:
        grid = []
        for r in file.readlines():
            grid.append(list(map(int,r.strip().split(' '))))

    firstline = grid[0]
    rides = grid[1:]

    print(rides)
    rides = sorted(rides,key=lambda ride:distance(ride))

    distanceMatrix = []
    for c in rides:
        row = []
        for r in rides:
            row.append(abs((c[3]-c[2])-(r[1]-r[0])))
        distanceMatrix.append(row)

    print (distanceMatrix)



"""
Sort the grid by starting time
If it is possible to complete the ride in time, assign it to the first car

"""