def solution(arr):
    answer = 0
    for i in range(0, len(arr)):
        answer += arr[i]
        
    return answer/len(arr)