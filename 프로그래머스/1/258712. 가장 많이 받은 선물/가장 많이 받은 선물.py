def solution(friends, gifts):
    answer = [0 for i in range(len(friends))]
    data = [[0 for j in range(len(friends))] for i in range(len(friends))]
    
    for i in gifts:
        a, b = i.split(" ")
        data[friends.index(a)][friends.index(b)] += 1
        
    for i in range(len(friends) - 1):
        for j in range(i + 1, len(friends)):
            g1 = data[i][j]
            g2 = data[j][i]
            
            if g1 > g2:
                answer[i] += 1
            elif g2 > g1:
                answer[j] += 1
            else:
                g1_index = sum(data[i])
                g2_index = sum(data[j])
                
                for k in data:
                    g1_index -= k[i]
                    g2_index -= k[j]
                    
                if g1_index > g2_index:
                    answer[i] += 1
                elif g2_index > g1_index:
                    answer[j] += 1
    
    return max(answer)