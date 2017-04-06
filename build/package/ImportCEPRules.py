#-*- coding: UTF-8 -*- 

import urllib2
import json
import os
import time

headers = {'Content-Type': 'application/json;charset=UTF-8'}
url = 'http://172.16.100.241:8765/api/cep/rules-importexport'

def scanDir(rootdir):
    list = os.listdir(rootdir) #列出文件夹下所有的目录与文件
    allFiles = {}
    for i in range(0,len(list)):
        path = os.path.join(rootdir,list[i])
        if os.path.isfile(path):
            allFiles[list[i]] = path
    return allFiles


def readCEPRuleFile(fileName):
    f = open(fileName)
    fr = f.read()
    f.close()
    return fr

def sendRequestToCEP(url, content):
    request = urllib2.Request(url, headers=headers, data=content)
    response = urllib2.urlopen(request)
    res = response.read()
    if response.getcode() != 200:
        print 'import failed: '+url
    else:
        print 'import ok: '+url    
    response.close()
    print '--->'+res

def main():
    allFiles = scanDir('./rules')
    for (key,value) in allFiles.items():
        #print key, ':', value
        content = readCEPRuleFile(value)
        #print content
        sendRequestToCEP(url+'?ruleType='+key, content)
        time.sleep(5)
    print '导入规则完成！'
     
if __name__ == '__main__':
    main()
