def solution(a, b, g, s, w, t):
    answer = (10**9) * (10**5) * 2 * 2 # 초기: 최악의 시간
    # 최대 광물 무게 * 최대 시간 * 왕복(2) * 금, 은 따로(2)
    
    start = 0
    end = (10**9) * (10**5) * 2 * 2
    
    while start <= end:
        mid = (start + end) // 2
        gold = 0
        silver = 0
        total = 0
        
        for i in range(len(g)):
            # mid 시간동안 이동할 수 있는 횟수 
            move_cnt = mid // (t[i] * 2) # 왕복 계산
            
            if mid % (t[i] * 2) >= t[i]: 
                move_cnt += 1 # 편도 1회 가능하다면 추가
                
            gold += g[i] if (g[i] < move_cnt * w[i]) else move_cnt * w[i]
            silver += s[i] if (s[i] < move_cnt * w[i]) else move_cnt * w[i]
            total += g[i] + s[i] if (g[i] + s[i] < move_cnt * w[i]) else move_cnt * w[i]
        
        if gold >= a and silver >= b and total >= a + b:
            end = mid - 1
            answer = min(answer, mid)
        else:
            start = mid + 1
    
    return answer