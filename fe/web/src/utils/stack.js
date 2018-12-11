'use strict'

function Stack() {
  this.dataStore = []
  this.top = undefined
  this.pop = pop
  this.push = push
  this.peek = peek
  this.clear = clear
  this.length = length
  this.empty = empty
}

function pop() {
  const data = this.dataStore[--this.top]
  if (!data) {
    const j = JSON.parse(sessionStorage.getItem('historyStack'))
    j.top--
    sessionStorage.setItem('historyStack', JSON.stringify(j))
    return j.dataStore[j.top]
  } else {
    return data
  }
}

function push(element) {
  this.dataStore[this.top++] = element
  sessionStorage.setItem('historyStack', JSON.stringify(this))
}

function peek() {
  const data = this.dataStore[this.top - 1]
  if (!data) {
    const j = JSON.parse(sessionStorage.getItem('historyStack'))
    return j.dataStore[j.top - 1]
  } else {
    return data
  }
}

function clear() {
  delete this.dataStore
  this.dataStore = []
  this.top = undefined
  sessionStorage.setItem('historyStack', JSON.stringify(this))
}

function length() {
  if (this.top === undefined) {
    const j = JSON.parse(sessionStorage.getItem('historyStack'))
    return j.top
  } else {
    return this.top
  }
}

function empty() {
  if (this.top === undefined) {
    const j = JSON.parse(sessionStorage.getItem('historyStack'))
    return j.top === 0
  } else {
    return this.top === 0
  }
}

export default Stack
