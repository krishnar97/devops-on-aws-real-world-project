# BookNova - details service (Ruby)
# A tiny web service that returns book details as JSON.

require 'webrick'
require 'json'

BOOK = {
  id: 1,
  author: 'William Shakespeare',
  year: 1595,
  type: 'paperback',
  pages: 200,
  publisher: 'BookNova Press',
  language: 'English',
  ISBN: '978-1234567890'
}

server = WEBrick::HTTPServer.new(Port: 7070)

server.mount_proc '/health' do |req, res|
  res.status = 200
  res['Content-Type'] = 'application/json'
  res.body = { status: 'ok' }.to_json
end

server.mount_proc '/details' do |req, res|
  res.status = 200
  res['Content-Type'] = 'application/json'
  res.body = BOOK.to_json
end

trap('INT') { server.shutdown }
server.start
