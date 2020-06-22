def main():
    gmk = []
    fp = open('C:\Users\Min\git\open_source_gmk/score.csv','r')
    lines = fp.readlines()
    fp.close()
    for line in lines:
        line = line.strip()   
        items = line.split(',')
        gm = {}
        gm['id'] = int(items[0])
        gm['name'] = items[1]
        gm['korean'] = int(items[2])
        gm['english'] = int(items[3])
        gm['math'] = int(items[4])
        gm['total'] = 0
        gm['avg'] = 0.0
        gm['rank'] = 0
        
        gmk.append(gm)
        
    for gm in gmk:
        gm['total'] = gm['korean'] + gm['english'] + gm['math'] 
        gm['avg'] = gm['total'] / 3    
           
    sorted_gmk = sorted(gmk, key = lambda x : x['total'], reverse=True)

    count = 1
    for gm in sorted_gmk:
        gm['rank'] = count
        count = count + 1
        
    result_gmk = sorted(sorted_gmk, key = lambda x : x['id'])
    
    fp = open('C:\Users\Min\git\open_source_gmk/result_score.csv', 'w')
    
    for gm in result_gmk:
        line = ','.join([str(gm['id']),str(gm['name']),str(gm['korean']),str(gm['english']),
                         str(gm['math']),str(gm['total']),str(gm['avg']),str(gm['rank']),'\n'])
        fp.write(line)
        
    fp.close()
        
    for gm in sorted_gmk:
        print(gm) 
     
if __name__ == "__main__":
    main()
