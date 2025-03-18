def solution(new_id):
    new_id = new_id.lower()
    check = []
    
    for i in new_id:
        if i.isalpha() or i.isdigit() or i == '-' or i == '_' or i == '.':
            continue
        check.append(i)
    
    for i in check:
        new_id = new_id.replace(i, "")
    
    check = []
        
    while '..' in new_id:
        new_id = new_id.replace('..', '.')
        
    if len(new_id) > 0 and new_id[0] == '.':
        new_id = new_id[1:]
            
    if len(new_id) > 0 and new_id[-1] == '.':
        new_id = new_id[:-1]
        
    if new_id == '':
        new_id = 'a'
        
    if len(new_id) >= 16:
        new_id = new_id[:15]
        
        if new_id[-1] == '.':
            new_id = new_id[:-1]
            
    while len(new_id) <= 2:
        new_id = new_id + new_id[-1]
    
    return new_id