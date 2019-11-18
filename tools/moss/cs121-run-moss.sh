#!/bin/bash


if [ "$#" -lt 3 ];
then
	echo "Usage: setup-moss-taps.sh <course-section> <project> <files>"
	exit 1
fi

course="$1"
project="$2"
shift 2
files="$@"

submission_path="${HOME}/${course}/submissions/tmp.${project}"
moss_path="${HOME}/workspace/moss/$course"
moss_project_path="${moss_path}/${project}"
moss_base_path="${moss_path}/base"



if [ ! -d "${submission_path}" ];
then
	echo "Error: Unable to access project submission path: ${submission_path}"
	exit 1
fi

# Setup MOSS Folder Structure
mkdir -p ${moss_path}

mkdir -p ${moss_project_path}
mkdir -p ${moss_base_path}


cd ${submission_path}

for user in `ls`
do 
	if [ ! -d "$user" ] 
	then
		continue
	fi
	user_short=`echo $user | sed 's/@.*//'`
	echo "$user ($user_short)" 
	pwd

	mkdir -p ${moss_project_path}/${user_short}
	for file in ${files}
	do
	    cp $user/$file ${moss_project_path}/${user_short}
	done

done

cd ${moss_path}

base_files=""
user_files=""
for file in ${files}
do
    base_files="${base_files} -b ${moss_base_path}/${file}"
	user_files="${user_files} ${project}/*/${file}"
done

for file in ${base_files}
do
	if [ ${file} == "-b" ]
	then
		continue
	fi
	touch ${file}
done

cd ${moss_path}
moss -l java ${base_files} -d ${user_files}
