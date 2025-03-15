def solution(k, m, score):
    answer = 0
    
    score.sort()
    index = len(score)
    
    while index >= m:
        index -= m
        answer += score[index] * m
    
    return answer