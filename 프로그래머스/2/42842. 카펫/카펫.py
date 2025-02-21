def solution(brown, yellow):
    x = 0
    y = 1
    
    while True:
        if yellow % y == 0:
            a = 2 * (yellow // y)
            if brown - a == 2 * (y + 2):
                x = yellow // y + 2
                break
        y += 1
            
    answer = [x, y + 2]      
    return answer