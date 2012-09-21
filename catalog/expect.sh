#!/usr/bin/expect -f
# Expect script to supply GAE's account password for appcfg.sh
#
# This script needs four arguments:
# username = GAE's google account email
# password = GAE's google account password
# warDir = war directory to deploy to GAE
# gaeHome = GAE's SDK home dir
#
# For example:
#  expect appcfg.exp myemail@gmail.com mypassword ./war /usr/share/appengine-sdk-1.5.3

if {[llength $argv] == 0} {
   puts "usage: appcfg.exp {-index|#}"
   exit 1
}

set gaeHome [lrange $argv 0 0]
set username [lrange $argv 1 1]
set password [lrange $argv 2 2]
set cmd [lrange $argv 3 3]
set warDir [lrange $argv 4 4]

set timeout -1

# spawns appcfg.sh
spawn $gaeHome/bin/appcfg.sh --enable_jar_splitting --passin --email=$username $cmd $warDir
match_max 100000

expect {
   default {exit 0}
   # Look for passwod prompt
   "*?assword*"
}

# Send password aka $password
send -- "$password\r"

# send blank line (\r) to make sure we get back to gui
send -- "\r"
expect eof
