def solution(sequence, k):
    answer = []
    
    left, right = 0, 0
    s = sequence[0]
    possible = []
    
    while True:
        if s < k:
            if (right + 1) < len(sequence):
                right += 1
                s += sequence[right]
            else:
                break
            
        elif s > k:
            s -= sequence[left]
            left += 1
            
        else:
            possible.append([left, right])
            s -= sequence[left]
            left += 1
            
    min_length = len(sequence) + 1
    
    for start, end in possible:
        if end - start + 1 < min_length:
            min_length = end - start + 1
            answer = [start, end]
        
    return answer