#!/usr/bin/ruby

require 'soap/wsdlDriver'

wsdl_url = 'http://127.0.0.1:9876/ts?wsdl'

service = SOAP::WSDLDriverFactory.new(wsdl_url).create_rpc_driver

service.wiredump_file_base = 'soapmsgs'

result1 = service.getTimeAsString
result2 = service.getTimeAsElapsed

puts "Current time is: #{result1}"
puts "Elapsed time is: #{result2}"
