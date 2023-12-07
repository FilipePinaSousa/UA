import json
import pprint

def lerFicheiro(filename):
    fi = open(filename)
    tweets = json.load(fi)
    return tweets

def quicksort(l):
    if len(l) <= 1:
        return l

    pivot_key, pivot_val = l[0]
    ant = [(e_k, e_v) for e_k, e_v in l[1:] if e_v < pivot_val]
    pos = [(e_k, e_v) for e_k, e_v in l[1:] if e_v >= pivot_val]
    return quicksort(ant) + [(pivot_key, pivot_val)] + quicksort(pos)


def ordenar(d):
    #converter dict para lista
    l = []
    for k,v in d.items():
        l.append((k, v))
    return quicksort(l)

def detectarHastagMaisPopular(tweets):
    c = dict()
    for t in tweets:
        for h in t['entities']['hashtags']:
            if not h['text'] in c:
                c[h['text']] = 0
            c[h['text']]+=1

    c_ord = ordenar(c)
    return c_ord[-1]

def detectarFalaBarato(tweets):
    c = dict()
    for t in tweets:
        if not t['user']['screen_name'] in c:
            c[t['user']['screen_name']] = 0
        c[t['user']['screen_name']]+=1

    c_ord = ordenar(c)

    maiores = [(e_k, e_v) for e_k, e_v in c_ord if e_v == c_ord[-1][1]]
    return maiores

t = lerFicheiro("twitter.json")
print(len(t))
print(detectarHastagMaisPopular(t))
print(detectarFalaBarato(t))






