import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/hr/login',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/hr/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/hr/logout',
    method: 'get'
  })
}
